package info.mores.parkmyslot.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mukeshsolanki.OTP_VIEW_TYPE_BORDER
import com.mukeshsolanki.OtpView
import info.mores.parkmyslot.Screen

@Preview
@Composable
fun OTPScreen(navController: NavHostController) {
    var isCheck by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            var otpValue by remember { mutableStateOf("") }
            OtpView(
                otpText = otpValue,
                onOtpTextChange = {
                    otpValue = it
                    Log.d("Actual Value", otpValue)
                },
                type = OTP_VIEW_TYPE_BORDER,
                password = true,
                containerSize = 48.dp,
                passwordChar = "•",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                charColor = MaterialTheme.colorScheme.primary
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isCheck,
                    onCheckedChange = {
                        isCheck = it
                    }
                )
                Text(
                    text = "Accept Terms & Conditions",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        isCheck = !isCheck
                    }
                )
            }



            Button(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(vertical = 20.dp),
                onClick = { navController.navigate(Screen.Dashboard.route) },
                enabled = (
                        otpValue.isNotEmpty() && isCheck
                        )
            ) {
                Text(
                    text = "Verify",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
