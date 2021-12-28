package com.project.realEstate.Services;

import com.project.realEstate.Entities.Picture;
import com.project.realEstate.Entities.Property;
import com.project.realEstate.Entities.Seller;
import com.project.realEstate.Repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;



    public void validate(String title, int price, Picture picture, String description, int room, int wc, int parking, Seller seller){

        if (title.isEmpty()){
            throw new IllegalStateException("Tittle can't be empty");
        }
        if (price<0){
            throw new IllegalStateException("Price can't be empty");
        }
        if (description.isEmpty()){
            throw new IllegalStateException("Description can't be empty");
        }
        if(room <0 || room > 20){
            throw new IllegalStateException("Rooms can't be less than cero or greater than 20");
        }
        if(wc <0 || wc > 20){
            throw new IllegalStateException("wc can't be less than cero or greater than 20");
        }
        if(parking <0 || parking > 20){
            throw new IllegalStateException("parking can't be less than cero or grater than 20");
        }
        if(seller.equals(null)){
            throw new IllegalStateException("Seller cant be null");
        }
        if (picture.equals(null)){
            throw new IllegalStateException("Photo can't be null");
        }

    }

    @Transactional
    public void createProperty(Property property){

        validate(property.getTitle(), property.getPrice(), property.getPicture(), property.getDescription(),
                property.getRoom(), property.getWc(), property.getParking(), property.getSeller());

        Property property1 = new Property(
                property.getTitle(), property.getPrice(), property.getPicture(), property.getDescription(), property.getRoom(), property.getWc(),
                property.getParking(), LocalDateTime.now(), property.getSeller()
        );

        propertyRepository.save(property1);




    }

}
