# Etapa 2 - Santa Claus is Coming to ACS Students
_Popa Ioana Theodora,_
_323CD_

##Design Patterns
For the following implementation, I have used four Design Patterns, which are:

1. ***Singleton Design Pattern*** applied on the class Santa in order to get only one instance
of this class

2. ***Visitor Design Pattern*** used in order to get the right average grade depending on the
category the child is part of(Baby, Kid, Teen). I have not added the class YoungAdult,
as we do not apply any action on a child with the age over 18.

3. ***Strategy Design Pattern*** utilized in order to get the right actions depending on
the class. Therefore, I used it for performing the actions accordingly to the elf assigned 
to the child and for getting the right order of child duly to the strategy of the year

4. ***Factory Design Pattern*** used for obtaining the correct instances for the elf and strategy
classes

##Packages and Classes
* ***annualChanges***, which contains the classes:

  * AnnualChanges - has the information needed for the _numberOfYears_ years
    Santa is giving gifts
    --> ChildUpdate - contains a child's update information in one year

* ***children***, which contains the classes and interfaces:

    * Child: contains all the initial information about a child
    * Baby: extends the class Child and contains the "accept" method, used for
    Double Dispatching and further for using the Visitor Pattern. The class represents 
    the children with the age under 5.
    * Kid:  extends the class Child and contains the "accept" method, used for
    Double Dispatching and further for using the Visitor Pattern. The class represents 
    the children with the age under 12.
    * Teen:  extends the class Child and contains the "accept" method, used for
     Double Dispatching and further for using the Visitor Pattern. The class represents 
     the children with the age under 18.
    * Visitable: interface implemented by the class Child

* ***elves***, that generates the right instances of the elf type and computes their actions,
containing the following classes and interfaces:
  * ElfFactory - creates an ElfStrategy instance depending on the elf type, using the Factory Design
Pattern
  * ElfStrategy - interface implemented in order to use further the Strategy Design Pattern,
containing methods for the two actions an elf can make: modify the budget of the child and share
one gift in the end(only performed by the yellow elf)
  * BlackElf, PinkElf, WhiteElf, YellowElf - classes that implement the ElfStrategy the methods
  accordingly to their actions

* ***fileio***, which contains multiple classes that writing the files and manage converting the input
from JSONObjects to the needed types and the output from the classes we have previously worked with
into JSONObjects

* ***gifts***, which contains the class Gift, which has the information about gifts

* ***santa***, which contains the class and interface:

  * Visitor: interface that declares the methods used for implementing the Visitor Pattern
    * Santa: Singleton class that implements the Visitor interface, that has fields for
    all the data about children, gifts, number of years, budget and annual changes.
    In the class, the methods "visit" return the child's average grade depending on the child
    category as specified in the problem.

* ***santatodo***, which contains the classes:

  * SantaList: adds the information to the Santa instance
    * ShareGifts: computes the actions in order to share the gifts to the children for the
    given number of years. For every year, we update the information about the children using
    the Update class, gets the average grade for every child that takes part in the "round",
    calculates the assigned budget and shares the gifts as specified.
    * Update:  adds new children, updates the information of every child and Santa's list of gifts.

* ***strategy***, package that manages the strategy approached in the current year and contains
the following classes
    * StrategyFactory - class that generates the right instance of the Strategy class and that 
implements the Factory Design Pattern
    * Strategy - abstract class implemented in order to use further the Strategy Design Pattern,
containing methods needed for setting the right strategy
    * ID, NiceScore, NiceScoreCity - classes that extend the Strategy class and implement the 
  method accordingly to the strategy of the current year
    * CalculateNiceScoreCity - computes the nice scores of the cities