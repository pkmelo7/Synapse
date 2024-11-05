// @author pkmelo7

package com.mycompany.synapse;

import com.mycompany.DAO.ConnectionFactory;

public class Synapse {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ConnectionFactory cf = new ConnectionFactory();
        cf.obtemConexao();
    }
}
