package in.strikes.hibernateDemo.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter
                implements AttributeConverter<Boolean,String> {


    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if(aBoolean==null){
            return "null";
        }
        if(aBoolean){
            return "Yes";
        }
        return "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        if(s.equals("null")){
            return null;
        }
        return s.equals("Yes");
    }
}
