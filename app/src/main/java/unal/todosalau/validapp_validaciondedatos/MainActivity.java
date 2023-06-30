package unal.todosalau.validapp_validaciondedatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import unal.todosalau.validapp_validaciondedatos.modelos.DataValidator;

public class MainActivity extends AppCompatActivity {


private EditText editTextName, editTextEmail, editTextPhone;
private TextView textViewResult;

private DataValidator dataValidator;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Inicializar vistas
    editTextName = findViewById(R.id.editTextName);
    editTextEmail = findViewById(R.id.editTextEmail);
    editTextPhone = findViewById(R.id.editTextPhone);
    textViewResult = findViewById(R.id.textViewResult);
    Button buttonValidate = findViewById(R.id.buttonValidate);

    // Inicializar el objeto DataValidator
    dataValidator = new DataValidator();

    // Configurar el click listener del botón de validación
    buttonValidate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validateData();
        }
    });
}

// Método para validar los datos ingresados
private void validateData() {
    // Obtener los valores de los campos de texto
    String name = editTextName.getText().toString();
    String email = editTextEmail.getText().toString();
    String phone = editTextPhone.getText().toString();

    // Validar los datos utilizando el objeto DataValidator
    boolean isNameValid = dataValidator.validateName(name);
    boolean isEmailValid = dataValidator.validateEmail(email);
    boolean isPhoneValid = dataValidator.validatePhone(phone);

    // Mostrar el resultado de la validación
    if (isNameValid && isEmailValid && isPhoneValid) {
        // Si todos los datos son válidos
        textViewResult.setText("¡Todos los datos son válidos!");
        textViewResult.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
    } else {
        // Si hay datos inválidos
        String errorMessage = "Los siguientes datos no son válidos:\n";
        if (!isNameValid) {
            errorMessage += "- Nombre\n";
        }
        if (!isEmailValid) {
            errorMessage += "- Correo electrónico\n";
        }
        if (!isPhoneValid) {
            errorMessage += "- Teléfono\n";
        }
        textViewResult.setText(errorMessage);
        textViewResult.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

        // Mostrar el mensaje de error en un Toast
        Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
    }

    // Mostrar la lista de errores de validación
    String validationErrors = "Errores de validación:\n";
    if (!isNameValid) {
        validationErrors += "- El nombre es inválido.\n";
    }
    if (!isEmailValid) {
        validationErrors += "- El correo electrónico es inválido.\n";
    }
    if (!isPhoneValid) {
        validationErrors += "- El teléfono es inválido.\n";
    }
    Toast.makeText(MainActivity.this, validationErrors, Toast.LENGTH_LONG).show();
}
}