package com.journaldev.design.model;
public abstract class Computer {

 public abstract String getRAM();
 public abstract String getHDD();
 public abstract String getCPU();

 @Override
 public String toString(){
 return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+",CPU="+this.getCPU();
 }
} ///Super class in a factory pattern, it used for testing purpose and can be an interface.

//B. Subclasses

package com.journaldev.design.model;
public class PC extends Computer {
 private String ram;
 private String hdd;
 private String cpu;

 public PC(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public String getRAM() {
 return this.ram;
 }
 @Override
 public String getHDD() {
 return this.hdd;
 }
 @Override
 public String getCPU() {
 return this.cpu;
 }
}

package com.journaldev.design.model;
public class Server extends Computer {
 private String ram;
 private String hdd;
 private String cpu;

 public Server(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }

 @Override
 public String getRAM() {
 return this.ram;
 }
 @Override
 public String getHDD() {
 return this.hdd;
 }
 @Override
 public String getCPU() {
 return this.cpu;
 }
} /// Классы PC и Server (PC.java и Server.java):
 
 //Эти классы представляют конкретные подклассы компьютеров (Computer). У каждого из них есть свойство RAM (оперативная память), HDD (жесткий диск) и CPU (процессор).
//Конструкторы этих классов инициализируют значения для RAM, HDD и CPU.
//Методы getRAM(), getHDD() и getCPU() возвращают значения соответствующих свойств.
//Kласс ComputerFactory (ComputerFactory.java):

//Этот класс представляет фабрику для создания объектов типа Computer.
//У него есть статический метод getComputer(), который принимает тип компьютера (PC или Server) и параметры RAM, HDD и CPU.
//В зависимости от указанного типа, метод создает соответствующий объект и возвращает его.

//C. Factory class

package com.journaldev.design.factory;
import com.journaldev.design.model.Computer;
import com.journaldev.design.model.PC;
import com.journaldev.design.model.Server;
public class ComputerFactory {
 public static Computer getComputer(String type, String ram, String
hdd, String cpu){
 if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
 else if("Server".equalsIgnoreCase(type)) return new Server(ram,hdd, cpu);
 return null;
 }
}

package com.journaldev.design.test;
import com.journaldev.design.abstractfactory.PCFactory;
import com.journaldev.design.abstractfactory.ServerFactory;
import com.journaldev.design.factory.ComputerFactory;
import com.journaldev.design.model.Computer;
public class TestFactory {
 public static void main(String[] args) {
 Computer pc = ComputerFactory.getComputer("pc","2 GB","500GB","2.4 GHz");
 Computer server = ComputerFactory.getComputer("server","16GB","1 TB","2.9 GHz");
 System.out.println("Factory PC Config::"+pc);
 System.out.println("Factory Server Config::"+server);
 }
}
//Класс TestFactory (TestFactory.java):

//Этот класс содержит метод main(), который представляет точку входа в программу.
//В методе main() создаются два компьютера: pc и server, с использованием метода getComputer() из ComputerFactory.
//Затем выводятся конфигурации созданных компьютеров на консоль.
//Tаким образом, данный код демонстрирует использование фабричного метода для создания объектов различных типов 
//компьютеров с заданными характеристиками. 
//Это позволяет упростить процесс создания объектов и управление их конфигурациями.
//A. Super class and sub-classes

package com.journaldev.design.model;

public abstract class Computer {

 public abstract String getRAM();
 public abstract String getHDD();
 public abstract String getCPU();

 @Override
 public String toString(){
 return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+",
CPU="+this.getCPU();
 }
}
package com.journaldev.design.model;


public class PC extends Computer {
private String ram;
 private String hdd;
 private String cpu;

 public PC(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public String getRAM() {
 return this.ram;
 }

 @Override
 public String getHDD() {
 return this.hdd;
 }

 @Override
 public String getCPU() {
 return this.cpu;
 }

}
package com.journaldev.design.model;


public class Server extends Computer {

 private String ram;
 private String hdd;
 private String cpu;

 public Server(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public String getRAM() {
 return this.ram;
 }

 @Override
 public String getHDD() {
 return this.hdd;
 }

 @Override
 public String getCPU() {
 return this.cpu;
 }

} /// В паттерне "Абстрактная фабрика" мы избавляемся от блока if-else и имеем отдельный класс фабрики для каждого подкласса, 
//а также абстрактный класс фабрики, который будет возвращать подкласс на основе входного класса фабрики. 
//Как и в нашей статье о паттерне фабрики, мы будем использовать тот же суперкласс и подклассы.
//B. Factory Classes for Each sub-classes

/// First of all we need to create an Abstract Factory interface or abstract class.

package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
public interface ComputerAbstractFactory {
 public Computer createComputer();
} /// 
///Notice that createComputer() method is returning an instance of super class
//Computer. Now our factory classes will implement this interface and return
//their respective sub-class.

package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
import com.journaldev.design.model.PC;
public class PCFactory implements ComputerAbstractFactory {
 private String ram;
 private String hdd;
 private String cpu;

public PCFactory(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public Computer createComputer() {
 return new PC(ram,hdd,cpu);
 }
}
//Similarly we will have a factory class for Server sub-class.

package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
import com.journaldev.design.model.Server;
public class ServerFactory implements ComputerAbstractFactory {
 private String ram;
 private String hdd;
 private String cpu;

 public ServerFactory(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }

 @Override
 public Computer createComputer() {
 return new Server(ram,hdd,cpu);
 }
} /// Now we will create a consumer class that will provide the entry point for the
client classes to create sub-classes.

package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
public class ComputerFactory {
public static Computer getComputer(ComputerAbstractFactory factory){
return factory.createComputer();
}
} /// Notice that it’s a simple class and getComputer method is accepting
//ComputerAbstractFactory argument and returning Computer object. At this
//point the implementation must be getting clear.
//Let’s write a simple test method and see how to use the abstract factory to
//get the instance of sub-classes.

package com.journaldev.design.test;
import com.journaldev.design.abstractfactory.PCFactory;
import com.journaldev.design.abstractfactory.ServerFactory;
import com.journaldev.design.factory.ComputerFactory;
import com.journaldev.design.model.Computer;
public class TestDesignPatterns {
 public static void main(String[] args) {
 testAbstractFactory();
 }
 private static void testAbstractFactory() {
 Computer pc =
com.journaldev.design.abstractfactory.ComputerFactory.getComputer(new
PCFactory("2 GB","500 GB","2.4 GHz"));
 Computer server =
com.journaldev.design.abstractfactory.ComputerFactory.getComputer(new
ServerFactory("16 GB","1 TB","2.9 GHz"));
 System.out.println("AbstractFactory PC Config::"+pc);
 System.out.println("AbstractFactory Server Config::"+server);
 }
}
Output of the above program will be:
AbstractFactory PC Config::RAM= 2 GB, HDD=500 GB, CPU=2.4 GHz
AbstractFactory Server Config::RAM= 16 GB, HDD=1 TB, CPU=2.9 GHz

//Этот код демонстрирует использование паттерна "Абстрактная фабрика" для создания объектов различных подклассов `Computer` (например, `PC` и `Server`) без явного использования блока `if-else`. Давайте разберем его пошагово:

/*1. **Интерфейс `ComputerAbstractFactory`** (`ComputerAbstractFactory.java`):
- Этот интерфейс определяет метод `createComputer()`, который должен быть реализован всеми фабриками. Метод возвращает объект суперкласса `Computer`.

2. **Класс `PCFactory`** (`PCFactory.java`):
   - Этот класс представляет конкретную фабрику для создания объектов класса `PC`.
   - Конструктор этого класса принимает параметры RAM, HDD и CPU.
   - Реализует метод `createComputer()`, который создает и возвращает объект класса `PC` с заданными характеристиками.

3. **Класс `ServerFactory`** (`ServerFactory.java`):
   - Этот класс представляет конкретную фабрику для создания объектов класса `Server`.
   - Конструктор этого класса также принимает параметры RAM, HDD и CPU.
   - Реализует метод `createComputer()`, который создает и возвращает объект класса `Server` с заданными характеристиками.

4. **Класс `ComputerFactory`** (`ComputerFactory.java`):
   - Этот класс предоставляет статический метод `getComputer()`, который принимает аргумент типа `ComputerAbstractFactory`.
   - Метод `getComputer()` использует переданную фабрику для создания объекта компьютера с помощью метода `createComputer()`.

5. **Класс `TestDesignPatterns`** (`TestDesignPatterns.java`):
   - Этот класс содержит метод `main()`, который представляет точку входа в программу.
   - В методе `testAbstractFactory()` создаются объекты `pc` и `server`, используя `ComputerFactory.getComputer()`, передавая соответствующие фабрики (`PCFactory` и `ServerFactory`) и их характеристики в качестве аргументов.
   - Затем выводятся информация о конфигурации созданных компьютеров на консоль с помощью методов `toString()`.*/

///Используя этот код, можно создавать объекты `PC` и `Server`, не заботясь о деталях их конкретной реализации. Паттерн "Абстрактная фабрика" обеспечивает абстракцию и упрощает процесс создания объектов, делая код более гибким и поддерживаемым.///