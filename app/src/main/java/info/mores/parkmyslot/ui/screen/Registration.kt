package info.mores.parkmyslot.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import info.mores.parkmyslot.Screen

@Preview(showSystemUi = true)
@Composable
fun Registration(navController: NavHostController?) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var firstNameValue by remember {
            mutableStateOf("")
        }

        var lastNameValue by remember {
            mutableStateOf("")
        }
        var emailValue by remember {
            mutableStateOf("")
        }
        var numberValue by remember {
            mutableStateOf("")
        }



        Icon(
            Icons.TwoTone.Face,
            contentDescription = "",
            modifier = Modifier.size(50.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Sing - Up",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(vertical = 25.dp)
        )

        OutlinedTextField(
            value = firstNameValue, onValueChange = { firstNameValue = it },
            label = { Text(text = "Enter First Name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = lastNameValue, onValueChange = { lastNameValue = it },
            label = { Text(text = "Enter Last Name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = emailValue,
            onValueChange = { emailValue = it },
            label = { Text(text = "Enter Email Id") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = numberValue,
            onValueChange = { if (it.length < 11) numberValue = it },
            label = { Text(text = "Enter Mobile Number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
        )

        Button(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(vertical = 20.dp),
            onClick = { },
            enabled = (
                    numberValue.isNotEmpty() &&
                            emailValue.isNotEmpty() &&
                            firstNameValue.isNotEmpty()
                            && lastNameValue.isNotEmpty()
                    )
        ) {
            Text(
                text = "Sing - Up",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }


        Text(
            text = "Already have account",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(vertical = 25.dp)
                .clickable {
                    navController?.navigate(Screen.Login.route)
                }
        )
    }
}