package eca.student.session1.Homework2;

/**
 * Created by anmcghee on 9/21/16.
 */
//Interfaces are generic and meant to be implemented
public interface Validator {
    int			getMin();
    int			getMax();

    void		setValid(int index);
    void		setValid(int index, boolean isValid);
    boolean		isValid(int index);
    int			getValidCount();
}
