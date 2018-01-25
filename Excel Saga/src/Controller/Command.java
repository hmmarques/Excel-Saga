/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import logic.Cell;




/**
 *
 * @author Sergio Cruz
 */
public interface Command {
    public void Redo(Cell m [][]);
    public void Undo(Cell m [][]);
}
