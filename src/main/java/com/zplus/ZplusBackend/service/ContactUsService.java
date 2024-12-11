package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.ContactUsRequestDto;
import com.zplus.ZplusBackend.model.ContactUsMaster;

import java.util.List;

public interface ContactUsService {

    public Boolean create(ContactUsRequestDto contactUsRequestDto);

    public Boolean update(ContactUsRequestDto contactUsRequestDto);

    public Boolean delete(Integer contactId);

    public ContactUsMaster getContactUsById(Integer contactId);

    public List getAll();

    public long getCount();
}
