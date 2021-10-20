import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class physicianMedicalFormController implements Initializable{

    @FXML
    private TextField firstName1;

    @FXML
    private TextField lastName1;

    @FXML
    private TextField height1;

    @FXML
    private TextField temp1;

    @FXML
    private TextField weight1;

    @FXML
    private TextField bloodPress1;

    @FXML
    private TextField symptoms1;

    @FXML
    private TextField medications1;

    @FXML
    private TextField tests1;

    @FXML
    private TextField diagnosis1;

    @FXML
    private TextField pulseRate1;

    @FXML
    void submitVitals(ActionEvent event) throws IOException {
        Main.patient.setHeight(Float.parseFloat(height1.getText()));
        Main.patient.setWeight(Float.parseFloat(weight1.getText()));
        Main.patient.setTemperature(Float.parseFloat(height1.getText()));
        Main.patient.setBloodPressure(bloodPress1.getText());
        Main.patient.setPulseRate(pulseRate1.getText());

        DatabaseInterface.updatePatient(Main.patient);

        Parent nurseMenuParent = FXMLLoader.load(getClass().getResource("nurseMenu.fxml"));
        Scene nurseMenuScene = new Scene(nurseMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nurseMenuScene);
        window.show();
    }

    @FXML
    void toPhysicianMenu(ActionEvent event) throws IOException {
        Parent physicianMenuParent = FXMLLoader.load(getClass().getResource("physicianMenu.fxml"));
        Scene physicianMenuScene = new Scene(physicianMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(physicianMenuScene);
        window.show();
    }

    @FXML
    void toDiagnose(ActionEvent event) throws IOException {
        Parent diagnoseParent = FXMLLoader.load(getClass().getResource("diagnose.fxml"));
        Scene diagnoseScene = new Scene(diagnoseParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(diagnoseScene);
        window.show();
    }
    
    @FXML
    void toOrderMeds(ActionEvent event) throws IOException {
        Parent orderMedsParent = FXMLLoader.load(getClass().getResource("orderMeds.fxml"));
        Scene orderMedsScene = new Scene(orderMedsParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderMedsScene);
        window.show();
    }

    @FXML
    void toOrderTest(ActionEvent event) throws IOException {
        Parent orderTestParent = FXMLLoader.load(getClass().getResource("orderTest.fxml"));
        Scene orderTestScene = new Scene(orderTestParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(orderTestScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name = Main.patient.getName();
        String[] nameSplit = name.split(" ");
        firstName1.setText(nameSplit[0]);
        lastName1.setText(nameSplit[1]);

        Float f = (Float) Main.patient.getHeight();
        if(f == 0) height1.setText("");
        else height1.setText(f.toString());

        f = (Float) Main.patient.getWeight();
        if(f == 0) weight1.setText("");
        else weight1.setText(f.toString());

        f = (Float) Main.patient.getTemperature();
        if(f == 0) temp1.setText("");
        else temp1.setText(f.toString());

        String s = Main.patient.getBloodPressure();
        if(s == null) bloodPress1.setText("");
        else bloodPress1.setText(s);

        s = Main.patient.getPulseRate();
        if(s == null) pulseRate1.setText("");
        else pulseRate1.setText(s);

        
        symptoms1.setText(Main.patient.getSymptoms());

        StringBuilder sb = new StringBuilder();

        if(Main.patient.getPain() != 0) {
            sb.append("Pain: ");
            sb.append(Main.patient.getPain());
            sb.append("; ");
        }
        if(Main.patient.getAnticoagulant() != 0) {
            sb.append("Anticoagulant: ");
            sb.append(Main.patient.getAnticoagulant());
            sb.append("; ");
        }
        if(Main.patient.getBetaBlocker() != 0) {
            sb.append("Beta Blocker: ");
            sb.append(Main.patient.getBetaBlocker());
            sb.append("; ");
        }
        if(Main.patient.getAntiretroviral() != 0) {
            sb.append("Antiretroviral: ");
            sb.append(Main.patient.getAntiretroviral());
            sb.append("; ");
        }
        if(Main.patient.getInsulin() != 0) {
            sb.append("Insulin: ");
            sb.append(Main.patient.getInsulin());
            sb.append("; ");
        }
        if(Main.patient.getAntiInflammatory() != 0) {
            sb.append("Anti Inflammatory: ");
            sb.append(Main.patient.getAntiInflammatory());
            sb.append("; ");
        }
        if(Main.patient.getUrsodiol() != 0) {
            sb.append("Ursodiol: ");
            sb.append(Main.patient.getUrsodiol());
            sb.append("; ");
        }
        if(Main.patient.getCalciumReducer() != 0) {
            sb.append("Calcium Reducer: ");
            sb.append(Main.patient.getCalciumReducer());
            sb.append("; ");
        }

        medications1.setText(sb.toString());
        sb.setLength(0);

        if(Main.patient.getNucleicAcid())
            sb.append("Calcium Reducer; ");
        if(Main.patient.getCoagulationPanel())
            sb.append("Coagulation Panel; ");
        if(Main.patient.getDheaSulfateSerum())
            sb.append("Dhea Sulfate Serum; ");
        if(Main.patient.getcReactiveProtein())
            sb.append("C Reactive Protein; ");
        if(Main.patient.getAlc())
            sb.append("ALC; ");
        if(Main.patient.getXray())
            sb.append("XRay; ");
        if(Main.patient.getMri())
            sb.append("MRI; ");
        if(Main.patient.getCtScan())
            sb.append("CT Scan; ");
        if(Main.patient.getUrinalysis())
            sb.append("Urinalysis; ");
        if(Main.patient.getStoolCultures())
            sb.append("Stool Cultures; ");

        tests1.setText(sb.toString());
        sb.setLength(0);

        if(Main.patient.getBrokenBone())
            sb.append("Broken bone; ");
        if(Main.patient.getHeartAttack())
            sb.append("Heart attack; ");
        if(Main.patient.getLaceration())
            sb.append("Laceration; ");
        if(Main.patient.getHivAIDS())
            sb.append("HIV/AIDS; ");
        if(Main.patient.getLiverFailure())
            sb.append("Liver failure; ");
        if(Main.patient.getKidneyFailure())
            sb.append("Kidney Failure; ");
        if(Main.patient.getDiabetes())
            sb.append("Diabetes; ");
        if(Main.patient.getInfammatoryBowlDisease())
            sb.append("Inflammatory bowl disease; ");
        if(Main.patient.getStroke())
            sb.append("Stroke; ");
        if(Main.patient.getTornMuscleTendon())
            sb.append("Torn muscle/Tendon; ");

        diagnosis1.setText(sb.toString());
    }
}
