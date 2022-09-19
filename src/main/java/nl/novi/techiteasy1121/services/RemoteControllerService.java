package nl.novi.techiteasy1121.services;


import nl.novi.techiteasy1121.Dtos.RemoteControllerDTO;
import nl.novi.techiteasy1121.Dtos.TelevisionDto;
import nl.novi.techiteasy1121.Dtos.TelevisionInputDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.RemoteController;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {

    private  final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<RemoteControllerDTO> getAllRemoteControllers() {
        List<RemoteController> rcList = remoteControllerRepository.findAll();
        List<RemoteControllerDTO> rcDtoList = new ArrayList<>();

        for(RemoteController rc : rcList) {
            RemoteControllerDTO dto = transferToDto(rc);
            rcDtoList.add(dto);
        }
        return rcDtoList;
    }

    public List<RemoteControllerDTO> getAllRemoteControllersByBrand(String brand) {
        List<RemoteController> rcList = RemoteControllerRepository.findAllRemoteControllersByBrandEqualsIgnoreCase(brand);
        List<RemoteControllerDTO> rcDtoList = new ArrayList<>();

        for(RemoteController rc : rcList) {
            RemoteControllerDTO dto = transferToDto(rc);
            rcDtoList.add(dto);
        }
        return rcDtoList;
    }

    public RemoteControllerDTO getRemoteControllerById(Long id) {

        if (remoteControllerRepository.findById(id).isPresent()){
            RemoteController rc = RemoteControllerRepository.findById(id).get();
            return transferToDto(rc);
        } else {
            throw new RecordNotFoundException("geen remote controller gevonden");
        }
    }

    public RemoteControllerDTO addRemoteController(RemoteControllerInputDto dto) {

        RemoteController rc = transferToRemoteController(dto);
        RemoteControllerRepository.save(rc);

        return transferToDto(rc);
    }

    public void deleteRemoteController(@RequestBody Long id) {
        RemoteControllerRepository.deleteById(id);
    }

    public RemoteControllerDTO updateRemoteController(Long id, TelevisionInputDto inputDto) {

        if (remoteControllerRepository.findById(id).isPresent()){

            RemoteController rc = remoteControllerRepository.findById(id).get();

            RemoteController rc1 = transferToRemoteController(inputDto);
            rc1.setId(rc.getId());

            remoteControllerRepository.save(rc1);

            return transferToDto(rc1);

        } else {

            throw new  RecordNotFoundException("geen remote controller gevonden");

        }

    }

    public RemoteController transferToRemoteController(RemoteControllerInputDto dto){
        var remotecontroller = new RemoteController();

        remotecontroller.setId(dto.getId());
        remotecontroller.setCompatibleWith(dto.getCompatibleWith());
        remotecontroller.setBatteryType(dto.getBatteryType());
        remotecontroller.setName(dto.getName());
        remotecontroller.setBrand(dto.getBrand());
        remotecontroller.setPrice(dto.getPrice());
        remotecontroller.setOriginalStock(dto.getOriginalStock());

        return remotecontroller;
    }

    public RemoteControllerDTO transferToDto(RemoteController remotecontroller){
        RemoteControllerDTO dto = new RemoteControllerDTO();

        dto.setId(remotecontroller.getId());
        dto.setCompatibleWith(remotecontroller.getCompatibleWith());
        dto.setBatteryType(remotecontroller.getBatteryType());
        dto.setName(remotecontroller.getName());
        dto.setBrand(remotecontroller.getBrand());
        dto.setPrice(remotecontroller.getPrice());
        dto.setOriginalStock(remotecontroller.getOriginalStock());

        return dto;
    }
}
