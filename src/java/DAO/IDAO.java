/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Document;
import java.util.ArrayList;

/**
 *
 * @author Huawei
 */
public interface IDAO<T> {
public int insert(T Obj) ;
public int update(T Obj) ;
public int delete(T Obj) ;
public ArrayList<T> Select(String Obj) ;
public Document find(String Type,String Code) ;
}
