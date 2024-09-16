package com.example.androidenitp.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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

class ProgressDialogHelper {

    val showProgressDialog = MutableStateFlow<Boolean>(false)

    fun showProgressDialog(){
        showProgressDialog.value = true;
    }

    fun closeProgressDialog(){
        showProgressDialog.value = false;
    }

    @Composable
    fun renderProgress(){
        val showProgressDialogState by showProgressDialog.collectAsState();
        if (showProgressDialogState) {
            Dialog(onDismissRequest = {
                showProgressDialog.value = false;
            }) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.background(
                        Color.White,
                        shape = RoundedCornerShape((10.dp))
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator()
                        Text("Chargement en cours..")
                    }
                }
            }
        }
    }

    object Singleton {
        val progressDialogHelper = ProgressDialogHelper();
    }

}

