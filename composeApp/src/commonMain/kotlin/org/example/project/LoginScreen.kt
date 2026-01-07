package org.example.project



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(navController: NavController){
    val viewModel = remember{LoginViewModel()}
    val uiSate by viewModel.uiSate.collectAsSate()

    LoginScreenContent(
        uiSate = uiSate,
        onGoToForgotPassword = {
            navController.navigate(NavigationRoutes.ForgotPassword)
        },
        onEmailTextChanged = viewModel.onEmailTextChange,
        onLoginClick = viewModel.onLogin,
        onLoginResultReset = viewModel.onLoginResultReset,
        onPasswordTextChanged = viewModel.onPasswordTextChange
    )
}

@Composable
internal fun LoginScreenContent(
    uiState: LoginUiState,
    onGoToForgotPassword: () -> Unit,
    onEmailTextChanged: (String) -> Unit,
    onPasswordTextChanged: (String) -> Unit,
    onLoginClick: () -> Unit,
    onLoginResultReset: () -> Unit,

    ){
    Scaffold(
        bottomBar = {

        },
        snackbarHost ={

        },
        content ={
            Column (modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.fillMaxWidth().alpha(
                        0.8f
                    ).padding(bottom = 64.dp),
                    fontSize = 64.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    text = "Test"
                )
                TextField(
                    //modifier = reusableModifierTextField,
                    value = uiState.textEmail,
                    isError = uiState.isErrorEmail,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = onEmailTextChanged,
                    label = { "Email here" }
                )
            }

        }
    )
}