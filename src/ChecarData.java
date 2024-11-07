import java.time.LocalDate;

public class ChecarData {
    static void checkDate (LocalDate date) throws DataInvalida  
    {      
        LocalDate today = LocalDate.now();
        boolean isAfter = today.isAfter(date);
        if(isAfter){    
            throw new DataInvalida("Data invalida, selecione datas futuras");   
        }      
    }  
}
