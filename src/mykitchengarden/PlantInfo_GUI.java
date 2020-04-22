/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bruger
 */
public class PlantInfo_GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Back icon for the back button
        Image back_image = new Image("https://img.icons8.com/ios/40/000000/circled-left-2.png");
        ImageView back_view = new ImageView();
        back_view.setImage(back_image);
        
        //Setting the fit height and width of the login image
        back_view.setFitHeight(40); 
        back_view.setFitWidth(40);
        
        //Button to go back
        Button back_button = new Button("",back_view);
        back_button.setId("buttons");
        
        //Search field
        TextField search_field = new TextField();
        search_field.setPromptText("Søg");
        search_field.setPrefWidth(250);
        search_field.setMaxWidth(250);
        search_field.setStyle("-fx-font-size: 16px;");
        
        //Back icon for the add button
        Image add_image = new Image("https://i.imgur.com/32Mvm40.png");
        ImageView add_view = new ImageView();
        add_view.setImage(add_image);
        
        //Setting the fit height and width of the login image
        add_view.setFitHeight(30); 
        add_view.setFitWidth(30);
        
        //Button to go back
        Button add_button = new Button("",add_view);
        add_button.setId("buttons");
        
        //ListView for plant information
        ListView<String> info_list = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
            "Navn","Sort","Jord","Vand","Temperatur","Gødning","Høstning");
        info_list.setItems(items);
        info_list.setStyle("-fx-font-size: 14px;");
        
        //Make list unclickable
        info_list.setMouseTransparent(true);
        info_list.setFocusTraversable(false);
        
        //Setting the fit and width of the listView
        info_list.setPrefHeight(200);
        info_list.setMaxWidth(150);
        
        //Image of plant from database (not done)
        Image plant_image = new Image("https://sw1620.smartweb-static.com/upload_dir/pics/Morten-Krebs/1Tomat-Favorita.jpg");
        ImageView plant_view = new ImageView();
        plant_view.setImage(plant_image);
        
        //Setting the fit height and width of the image
        plant_view.setFitHeight(200); 
        plant_view.setFitWidth(150);
        
        
        //Title pane for presentation of the plant
        Label presentation_label = new Label("Info");
        TitledPane presentation_pane = new TitledPane("Præsentation af planten",presentation_label);
        presentation_pane.setStyle("-fx-font-size: 16px;");
        presentation_pane.setExpanded(false);
        
        
        //Title pane for harvesting the plant
        Label harvest_label = new Label("Info");
        TitledPane harvest_pane = new TitledPane("Sådan dyrkes de",harvest_label);
        harvest_pane.setStyle("-fx-font-size: 16px;");
        harvest_pane.setExpanded(false);
        
        //Title pane for how much sun the plant needs
        Label light_label = new Label("Info");
        TitledPane light_pane = new TitledPane("Lys",light_label);
        light_pane.setStyle("-fx-font-size: 16px;");
        light_pane.setExpanded(false);
        
        //Title pane for soil
        Label soil_label = new Label("Info");
        TitledPane soil_pane = new TitledPane("Jord",soil_label);
        soil_pane.setStyle("-fx-font-size: 16px;");
        soil_pane.setExpanded(false);
        
        //Title pane for water
        Label water_label = new Label("Info");
        TitledPane water_pane = new TitledPane("Vand",water_label);
        water_pane.setStyle("-fx-font-size: 16px;");
        water_pane.setExpanded(false);
        
        //Title pane for temperature and moist
        Label TM_label = new Label("Info");
        TitledPane TM_pane = new TitledPane("Temperatur og fugtighed",TM_label);
        TM_pane.setStyle("-fx-font-size: 16px;");
        TM_pane.setExpanded(false);
        
        //Title pane for temperture and moist
        Label fertilizer_label = new Label("Info");
        TitledPane fertilizer_pane = new TitledPane("Gødnig",fertilizer_label);
        fertilizer_pane.setStyle("-fx-font-size: 16px;");
        fertilizer_pane.setExpanded(false);
        
        //Putting the TitledPanes in the VBox
        VBox pane_box = new VBox();
        pane_box.setAlignment(Pos.CENTER);
        pane_box.getChildren().addAll(presentation_pane,harvest_pane,light_pane,soil_pane,water_pane,TM_pane,fertilizer_pane);
        
        //Putting icon buttons and search field in a HBox
        HBox top_box = new HBox();
        top_box.setSpacing(20);
        top_box.setAlignment(Pos.CENTER);
        top_box.getChildren().addAll(back_button,search_field,add_button);
        
        //Putting listView and image in HBox
        HBox listimage_box = new HBox();
        listimage_box.setSpacing(5);
        listimage_box.setAlignment(Pos.CENTER);
        listimage_box.getChildren().addAll(info_list,plant_view);
        
        //Putting top_box and listimage_box in VBOX
        VBox infoview_box = new VBox();
        infoview_box.setSpacing(40);
        infoview_box.setAlignment(Pos.CENTER);
        infoview_box.getChildren().addAll(top_box,listimage_box);
        
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setTop(infoview_box);
        layout.setCenter(pane_box);

        //Scene is created and put inside the primaryStage
        Scene plantinfo_scene = new Scene(layout, 357, 667);
        plantinfo_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(plantinfo_scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
    }
        public static void main(String[] args) {
        launch(args);        
    }
    
}