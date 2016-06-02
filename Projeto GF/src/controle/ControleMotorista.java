/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloMotorista;

/**
 *
 * @author Matheus
 */
public class ControleMotorista {
    ConexaoBD conex = new ConexaoBD();
    ModeloMotorista mod = new ModeloMotorista();
    
    public void salvar (ModeloMotorista pmod){
        conex.conecxao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into motorista(nomemotorista,idademotorista,cpfmotorista,datanascimentomotorista,categoriahabilitacaomotorista,dataadmicao) values(?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getIdade());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getDataNascimento());
            pst.setString(5, mod.getCategoriaHabilitacao());
            pst.setString(6, mod.getDataAdmicao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos no BD com Sucesso!");
        } catch (SQLException ex) {
            //Logger.getLogger(ControleMotorista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n" + ex.getMessage());
        }
        
        
        conex.desconecta();
    }
}
