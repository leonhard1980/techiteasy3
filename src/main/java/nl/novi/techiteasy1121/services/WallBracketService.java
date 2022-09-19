package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.Dtos.TelevisionDto;
import nl.novi.techiteasy1121.Dtos.TelevisionInputDto;
import nl.novi.techiteasy1121.Dtos.WallBracketDTO;
import nl.novi.techiteasy1121.Dtos.WallBracketInputDTO;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

 private final WallBracketRepository wallBracketRepository;

 public WallBracketService(WallBracketRepository wallBracketRepository){
     this.wallBracketRepository = wallBracketRepository;
 }

    public List<WallBracketDTO> getAllWallBrackets() {
        List<WallBracket> wbList = wallBracketRepository.findAll();
        List<WallBracketDTO> wbDtoList = new ArrayList<>();

        for(WallBracket wb : wbList) {
            WallBracketDTO dto = transferToDto(wb);
            wbDtoList.add(dto);
        }
        return wbDtoList;
    }

    public List<WallBracketDTO> getAllWallBracketsByBrand(String name) {
        List<WallBracket> wbList = wallBracketRepository.findAllWallBracketsByNameEqualsIgnoreCase(name);
        List<WallBracketDTO> wbDtoList = new ArrayList<>();

        for(WallBracket wb : wbList) {
            WallBracketDTO dto = transferToDto(wb);
            wbDtoList.add(dto);
        }
        return wbDtoList;
    }

    public WallBracketDTO getWallBracketById(Long id) {

        if (wallBracketRepository.findById(id).isPresent()){
            WallBracket wb = wallBracketRepository.findById(id).get();
            return transferToDto(wb);
        } else {
            throw new RecordNotFoundException("geen wallbracket gevonden");
        }
    }

    public WallBracketDTO addWallBracket(WallBracketInputDTO dto) {

        WallBracket wb = transferToWallBracket(dto);
        wallBracketRepository.save(wb);

        return transferToDto(wb);
    }

    public void deleteWallBracket(@RequestBody Long id) {

        wallBracketRepository.deleteById(id);

    }

    public WallBracketDTO updateWallBracket(Long id, WallBracketInputDTO inputDto) {

        if (wallBracketRepository.findById(id).isPresent()){

            WallBracket wb = wallBracketRepository.findById(id).get();

            WallBracket wb2 = transferToWallBracket(inputDto);
            wb2.setId(wb.getId());

            wallBracketRepository.save(wb2);

            return transferToDto(wb2);

        } else {

            throw new  RecordNotFoundException("geen wallbracket gevonden");

        }

    }

    public WallBracket transferToWallBracket(WallBracketInputDTO dto){
        var wallbracket = new WallBracket();

        wallbracket.setId(dto.getId());
        wallbracket.setSize(dto.getSize());
        wallbracket.setAjustable(dto.getAjustable());
        wallbracket.setName(dto.getName());
        wallbracket.setPrice(dto.getPrice());

        return wallbracket;
    }

    public WallBracketDTO transferToDto(WallBracket wallBracket){
        WallBracketDTO dto = new WallBracketDTO();

        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAjustable(wallBracket.getAjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());
        return dto;
    }

}
