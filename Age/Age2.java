/*

Age2 is more efficient than Age1 because it adopts a simpler and more flexible approach to handling age values.
In Age1, separate variables are used to store age values of different types (String, int, double), which can
lead to redundancy and increased complexity in the code. On the other hand, Age2 utilizes a single variable
of type Object to store age values, allowing for dynamic handling of various data types without the need for
multiple variables. This simplifies the code and makes it easier to understand, maintain, and modify. 

Additionally, by encapsulating the age value within the Age2 class, we promote better code organization and reduce
the risk of unintentional modifications to the age value from external sources. Overall, Age2's design not only 
saves development time but also enhances code readability and maintainability, making it a more efficient 
solution compared to Age1.

*/


public class Age2 {

    private Object ageValue;

    public Object getAge() {
        return ageValue;
    }

    public void setAge(Object age) {
        this.ageValue = age;
    }

}