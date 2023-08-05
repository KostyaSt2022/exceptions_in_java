/**
Задача 2: Файловый менеджер (ООП, исключения)

Создайте класс FileManager. Этот класс должен иметь методы для выполнения основных операций с файлами: 
чтение, запись и копирование. Каждый из этих методов должен выбрасывать соответствующее исключение, 
если в процессе выполнения операции произошла ошибка (например, FileNotFoundException, если файл не найден).
*/

//          В Java не силен и не интересен данный ЯП. Не понимаю почему так поздно поставили исключения в программировании. Java наверно почти пол года назад проходили.
//      Поставьте пожалуйста оценку :)

import java.io.File;
import java.io.IOException;
 
public class FileManager {
 
    public static void main(String[] args) {
         
        // просмотр файла
        File myFile = new File("C:/Users/sergs/OneDrive/Рабочий стол/exceptions_in_java/exceptions_in_java/sem3/for_manager4.txt"); 
        System.out.println("Имя файла: " + myFile.getName());
        System.out.println("Родительская папка: " + myFile.getParent());
        if(myFile.exists())
            System.out.println("Файл существует.");
        else
            System.out.println("Файл не найден.");
        System.out.println("Размер файла: " + myFile.length());
        if(myFile.canRead())
            System.out.println("Файл можно прочесть.");
        else
            System.out.println("Файл нельзя прочесть.");
         
        if(myFile.canWrite())
            System.out.println("Файл можно создать.");
        else
            System.out.println("Файл нельзя создать.");
         
        // создание нового файла
        File newFile = new File("C:/Users/sergs/OneDrive/Рабочий стол/exceptions_in_java/exceptions_in_java/sem3/for_manager3.txt");
        try
        {
            boolean created = newFile.createNewFile();
            if(created)
                System.out.println("Файл создан.");
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }  
    } 
}