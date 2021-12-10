/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sports.complex.registration.members;

import Database.DbQuery;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sports.complex.alert.AlertMaker;
import Classes.*;

/**
 * FXML Controller class
 *
 * @author Hamna Rauf
 */
public class RegisterGuestController implements Initializable {

    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField cnic;
    @FXML
    private JFXTextField memberId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleRegisterBtn(ActionEvent event) throws SQLException {
        String fname = firstName.getText();
        String lname = lastName.getText();
        String CNIC = cnic.getText();
        String id = memberId.getText();

        if (fname == null || lname == null || CNIC == null || id == null) {
            AlertMaker.showErrorMessage("Try Again", "Please Enter all feilds");
        } else {
            if (DbQuery.isMember(id)) {
                Guest g = new Guest(CNIC, id, fname, lname);
                DbQuery.registerGuest(g);
                AlertMaker.showSimpleAlert("Registeration successfull", "Success");
                
            } else {
                AlertMaker.showErrorMessage("Try Again", "Invalid Member id");
            }
        }
    }

}
