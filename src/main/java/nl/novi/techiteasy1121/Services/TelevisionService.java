package nl.novi.techiteasy1121.Services;

import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {
     private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevision(Long id) {
        if(televisionRepository.findById(id).isPresent()) {
            return televisionRepository.findById(id).get();
        } else {
            throw new RecordNotFoundException("This Television does not exist");
        }
    }

    public Television saveTelevision(Television newTelevision) {
        return televisionRepository.save(newTelevision);
    }

    public Television updateTelevision(Television updatedTV, Long id){
        Television tv = getTelevision(id);

       if(!tv.getBluetooth().equals(updatedTV.getBluetooth())) {
           tv.setBluetooth(updatedTV.getBluetooth());
        }

       if(!tv.getHdr().equals(updatedTV.getHdr())){
           tv.setHdr(updatedTV.getHdr());
       }

       if(!tv.getAmbiLight().equals(updatedTV.getAmbiLight())){
           tv.setAmbiLight(updatedTV.getAmbiLight());
       }

       if(!tv.getWifi().equals((updatedTV.getWifi()))) {
           tv.setWifi(updatedTV.getWifi());
       }

       if(!tv.getVoiceControl().equals(updatedTV.getVoiceControl())){
           tv.setVoiceControl(updatedTV.getVoiceControl());
       }

       if(!tv.getSmartTv().equals(updatedTV.getSmartTv())){
           tv.setSmartTv(updatedTV.getSmartTv());
       }

       if(!tv.getAvailableSize().equals(updatedTV.getAvailableSize())){
           tv.setAvailableSize(updatedTV.getAvailableSize());
       }

       if(!tv.getBrand().equals(updatedTV.getBrand())){
           tv.setBrand(updatedTV.getBrand());
       }

       if(!tv.getId().equals(updatedTV.getId())){
           tv.setId(updatedTV.getId());
       }

       if(!tv.getName().equals(updatedTV.getName())){
           tv.setName(updatedTV.getName());
       }

       if(!tv.getOriginalStock().equals(updatedTV.getOriginalStock())){
           tv.setOriginalStock(updatedTV.getOriginalStock());
       }

       if(!tv.getPrice().equals(updatedTV.getPrice())){
           tv.setPrice(updatedTV.getPrice());
       }

       if(!tv.getRefreshRate().equals(updatedTV.getRefreshRate())){
           tv.setRefreshRate(updatedTV.getRefreshRate());
       }

       if(!tv.getScreenQuality().equals(updatedTV.getScreenQuality())){
           tv.setScreenQuality(updatedTV.getScreenQuality());
       }

       if(!tv.getSmartTv().equals(updatedTV.getSmartTv())){
           tv.setSmartTv(updatedTV.getSmartTv());
       }

       if(!tv.getScreenType().equals(updatedTV.getScreenType())){
           tv.setScreenType(updatedTV.getScreenType());
       }

       if(!tv.getSold().equals(updatedTV.getSold())){
           tv.setSold(updatedTV.getSold());
       }
        return televisionRepository.save(tv);
    }


        public void deleteTelevision(Long id) {
            if (televisionRepository.findById(id).isEmpty()) {
                throw new RecordNotFoundException("Cannot find television");
            } else {
                televisionRepository.deleteById(id);
            }
        }
}
