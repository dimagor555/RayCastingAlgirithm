module RayCastingAlgirithm.main {
    requires javafx.controls;
    requires javafx.fxml;

    opens ru.dimagor555.raycasting to javafx.fxml;

    exports ru.dimagor555.raycasting;
}