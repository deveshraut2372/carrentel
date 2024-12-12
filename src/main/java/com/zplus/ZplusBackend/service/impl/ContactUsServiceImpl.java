package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.ContactUsDao;
import com.zplus.ZplusBackend.dto.req.ContactUsRequestDto;
import com.zplus.ZplusBackend.model.ContactUsMaster;
import com.zplus.ZplusBackend.service.ContactUsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsDao contactUsDao;
    @Override
    public Boolean create(ContactUsRequestDto contactUsRequestDto) {
        ContactUsMaster contactUsMaster = new ContactUsMaster();
        try {
            BeanUtils.copyProperties(contactUsRequestDto,contactUsMaster);
            contactUsMaster.setDate(new Date());
            contactUsMaster.setStatus("Active");
            this.contactUsDao.save(contactUsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(ContactUsRequestDto contactUsRequestDto) {
        ContactUsMaster contactUsMaster = new ContactUsMaster();
        contactUsMaster.setContactId(contactUsRequestDto.getContactId());
        BeanUtils.copyProperties(contactUsRequestDto,contactUsMaster);
        contactUsMaster.setDate(new Date());
//        contactUsMaster.setStatus("Active");
        try {
            this.contactUsDao.save(contactUsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Integer contactId) {
        try{
//            this.contactUsDao.deleteById(contactId);
            ContactUsMaster contactUsMaster = new ContactUsMaster();
            contactUsMaster = this.contactUsDao.findById(contactId).orElse(null);
            contactUsMaster.setStatus("InActive");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ContactUsMaster getContactUsById(Integer contactId) {
        ContactUsMaster contactUsMaster = new ContactUsMaster();

        try {
            Optional<ContactUsMaster> contactUsMaster1 = this.contactUsDao.findById(contactId);
            contactUsMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,contactUsMaster));
            return contactUsMaster;
        }catch (Exception e){
            e.printStackTrace();
            return contactUsMaster;
        }
    }

    @Override
    public List getAll() {
        return this.contactUsDao.findAll();
    }


    @Override
    public long getCount() {
        return this.contactUsDao.count();
    }
}
