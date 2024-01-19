package federicopignatelli.U2S2L5_backend_esercitazione.controllers;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.Device;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.exception.BadRequestException;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.device.NewDeviceDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.device.NewDeviceResponseDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewDeviceResponseDTO save(@RequestBody @Validated NewDeviceDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().toString());
        }
        Device newDevice = deviceService.save(body);
        return new NewDeviceResponseDTO(newDevice.getId(), newDevice.getDevicetype(), newDevice.getDevicestatus(), newDevice.getUser());
    }

    @GetMapping("")
    public Page<Device> getDevice(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return deviceService.getDevice(page, size, sortBy);
    }

    @GetMapping("/{deviceId}")
    public Device findById(@PathVariable UUID deviceId) {
        return deviceService.findById(deviceId);
    }

    @PutMapping("/{deviceId}")
    public Device findByIdAndUpdate(@PathVariable UUID deviceId, @RequestBody Device body) {
        return deviceService.findByIdAndUpdate(deviceId, body);
    }

    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID deviceId) {
        deviceService.findByIdAndDelete(deviceId);
    }
}

