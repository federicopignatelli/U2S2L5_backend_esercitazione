package federicopignatelli.U2S2L5_backend_esercitazione.services;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.Device;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.device.NewDeviceDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.repositories.DeviceRepository;
import federicopignatelli.U2S2L5_backend_esercitazione.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
