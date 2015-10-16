package org.kdea.upload;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;  
import org.springframework.validation.Validator;  
 
@Service("fileValidator")
public class FileValidator implements Validator {  
 
    public boolean supports(Class<?> arg0) {
        return false;
    }
 
    public void validate(Object uploadedFile, Errors errors) {  
           
        UploadedFile file = (UploadedFile) uploadedFile;  
           
        if (file.getFile().getSize() == 0) {  
            errors.rejectValue("file", "uploadForm.selectFile",  
                    "Please select a file!");  
        }
    }
    /*void rejectValue(String field,
            String errorCode,
            String defaultMessage)
Parameters:
field - the field name (may be null or empty String)
errorCode - error code, interpretable as a message key
defaultMessage - fallback default message*/
}