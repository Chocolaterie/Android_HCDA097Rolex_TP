package com.example.androidenitp.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.flow.MutableStateFlow

class AlertDialogHelper {

    val showAlertDialog = MutableStateFlow<Boolean>(false)
    val messageAlertDialog = MutableStateFlow<String>("")

    fun showAlert(message: String){
        showAlertDialog.value = true;
        messageAlertDialog.value = message;
    }

    fun closeAlert(){
        showAlertDialog.value = false;
        messageAlertDialog.value = "";
    }

    @Composable
    fun render(){
        val showAlertDialogState by showAlertDialog.collectAsState();
        val messageAlertDialogState by messageAlertDialog.collectAsState();

        if (showAlertDialogState) {
            Dialog(onDismissRequest = {
                closeAlert();
            }) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            Color.White,
                            shape = RoundedCornerShape((10.dp))
                        )
                        .padding(20.dp)
                ) {
                    Text(messageAlertDialogState)
                }
            }
        }
    }

    object Singleton {
        val alertDialogHelper = AlertDialogHelper();
    }
}