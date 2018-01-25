/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



/**
 *
 * @author Sergio Cruz
 */
public interface Command {
    public void Execute();
    public void Redo();
    public void Undo();
}
