import androidx.compose.runtime.Composable


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

        }
        snackbarHost ={

        }
        content ={

        }
    )
}