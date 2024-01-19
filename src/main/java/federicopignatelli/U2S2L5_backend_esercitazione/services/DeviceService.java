package federicopignatelli.U2S2L5_backend_esercitazione.services;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.Device;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.exception.NotFoundException;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.device.NewDeviceDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private UserService userService;

    public Device save(NewDeviceDTO body){

        User user = userService.findById(body.id());
        Device newDevice = new Device();
        newDevice.setDevicetype(body.devicetype());
        newDevice.setDevicestatus(body.devicestatus());
        newDevice.setUser(user);

        return deviceRepository.save(newDevice);
    }

    public Page<Device> getDevice(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return deviceRepository.findAll(pageable);
    }


    public Device findById(UUID id) {
        return deviceRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Device findByIdAndUpdate(UUID id, Device body) {

        Device found = this.findById(id);
        UUID userid = body.getId();
        User user = userService.findById(userid);

        found.setDevicetype(body.getDevicetype());
        found.setDevicestatus(body.getDevicestatus());
        found.setUser(user);

        return deviceRepository.save(found);
    }

    public void findByIdAndDelete(UUID id) {
        Device found = this.findById(id);
        deviceRepository.delete(found);
    }

}
