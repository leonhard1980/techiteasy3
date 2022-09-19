package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.Dtos.*;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.CIModule;
import nl.novi.techiteasy1121.repositories.CIModulesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {

    private final CIModulesRepository ciModulesRepository;

    public CIModuleService(CIModulesRepository ciModulesRepository) {
        this.ciModulesRepository = ciModulesRepository;
    }


    public List<CIModulesDTO> getAllCIModules() {
        List<CIModule> ciList = ciModulesRepository.findAll();
        List<CIModulesDTO> ciDtoList = new ArrayList<>();

        for(CIModule ci : ciList) {
            CIModulesDTO dto = transferToDto(ci);
            ciDtoList.add(dto);
        }
        return ciDtoList;
    }

    public List<CIModulesDTO> getAllCIModulesByBrand(String name) {
        List<CIModule> ciList = CIModulesRepository.findAllCIModulesByBrandEqualsIgnoreCase(name);
        List<CIModulesDTO> ciDtoList = new ArrayList<>();

        for(CIModule ci : ciList) {
            CIModulesDTO dto = transferToDto(ci);
            ciDtoList.add(dto);
        }
        return ciDtoList;
    }

    public CIModulesDTO getCIModuleById(Long id) {

        if (ciModulesRepository.findById(id).isPresent()){
            CIModule ci = CIModulesRepository.findById(id).get();
            return transferToDto(ci);
        } else {
            throw new RecordNotFoundException("geen CI Module gevonden");
        }
    }

    public CIModulesDTO addCIModules(CIModulesInputDTO dto) {

        CIModule ci = transferToCIModule(dto);
        CIModulesRepository.save(ci);

        return transferToDto(ci);
    }

    public void deleteCIModule(@RequestBody Long id) {
                ciModulesRepository.deleteById(id);
    }

    public CIModulesDTO updateCimodule(Long id, CIModulesInputDTO inputDto) {

        if (ciModulesRepository.findById(id).isPresent()){

            CIModule ci = ciModulesRepository.findById(id).get();

            CIModule ci1 = transferToCIModule(inputDto);
            ci1.setId(ci.getId());

            ciModulesRepository.save(ci1);

            return transferToDto(ci1);

        } else {

            throw new  RecordNotFoundException("geen ci module gevonden");

        }

    }

    public CIModule transferToCIModule(CIModulesInputDTO dto){
        var ciModule = new CIModule();

        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    public CIModulesDTO transferToDto(CIModule ciModule){
        CIModulesDTO dto = new CIModulesDTO();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());


        return dto;
    }
}




}
