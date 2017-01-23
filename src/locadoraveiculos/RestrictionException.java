/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

/**
 *
 * @author elyston
 */
public class RestrictionException extends Exception {

    /**
     * Creates a new instance of <code>RestrictionException</code> without
     * detail message.
     */
    public RestrictionException() {
    }

    /**
     * Constructs an instance of <code>RestrictionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RestrictionException(String msg) {
        super(msg);
    }
}
