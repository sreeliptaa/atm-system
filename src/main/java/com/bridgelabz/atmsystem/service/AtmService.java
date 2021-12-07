package com.bridgelabz.atmsystem.service;

import com.bridgelabz.atmsystem.dto.AtmDto;
import com.bridgelabz.atmsystem.entity.AtmEntity;
import com.bridgelabz.atmsystem.exception.ResourceNotFoundException;
import com.bridgelabz.atmsystem.repository.AtmRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Purpose: To implement all the methods in AtmService
 *
 * @author : SREELIPTA
 * @since : 04-12-2021
 */
@Service
public class AtmService {

    private static final String ATM_ADDED_SUCCESSFULLY = "Atm Added Successfully";
    private static final String ATM_UPDATED_SUCCESSFULLY = "Atm Updated Successfully";
    private static final String RECORD_DELETED_SUCCESSFULLY = "Record of that id deleted";

    @Autowired
    private AtmRepository atmRepo;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : To list all the records store in the Atm
     *
     * @return the list of all greeting messages
     */
    public List<AtmDto> getAllAtm() {
        return atmRepo
                .findAll()
                .stream()
                .map(atmEntity -> modelMapper.map(atmEntity, AtmDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Purpose : To add the atm records to the database
     *
     * @param atmDto :is used to add data from client
     * @return atm records are created
     */
    public String addAtm(AtmDto atmDto) {
        AtmEntity atmEntity = modelMapper.map(atmDto, AtmEntity.class);
        atmRepo.save(atmEntity);
        return ATM_ADDED_SUCCESSFULLY;
    }

    /**
     * Purpose : To update the available records in the database
     *
     * @param id             unique id of the records
     * @param atmDto getting data from client
     * @return updated records of the atm
     */
    public String updateAtm(int id, AtmDto atmDto) {
        Optional<AtmEntity> atmRecord = atmRepo.findById(id);
        if (atmRecord.isPresent()) {
            AtmEntity atmEntity = atmRecord.get();
            modelMapper.map(atmDto, atmEntity);
            atmRepo.save(atmEntity);
            return ATM_UPDATED_SUCCESSFULLY;
        }
        throw new ResourceNotFoundException("Atm Records with this id are not Found");
    }

    /**
     * Purpose : To delete particular record from the atm
     *
     * @param id unique id of the atm records
     * @return the status of the record which deleted or not
     */
    public String deleteAtm(int id) {
        Optional<AtmEntity> atmEntity = atmRepo.findById(id);
        if (atmEntity.isPresent()) {
            atmRepo.delete(atmEntity.get());
            return RECORD_DELETED_SUCCESSFULLY;
        }
        throw new ResourceNotFoundException("Record not found with this id : " + id);
    }
}
