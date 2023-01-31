package com.datum.carwashing.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.datum.carwashing.R

@Composable
fun SignInScreen(navController: NavHostController, string: String?) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }

    Scaffold(backgroundColor = colorResource(R.color.red_color)) {
        Column(Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(137.dp))
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Sign In", fontWeight = FontWeight.Bold, fontSize = 32.sp ,
                    style = TextStyle(
                        color = colorResource(R.color.white),

                        ))
            }

            Spacer(modifier = Modifier.height(48.dp))
            Box(modifier = Modifier.weight(2f)) {
                Spacer(
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.background))
                )
                Card(
                    Modifier
                        .padding(start = 15.dp , end = 15.dp , top = 8.dp),
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Column(

                        Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {
                        Column(Modifier.fillMaxSize()) {

                            TextField(
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.Transparent,
                                ),
                                value = username,
                                onValueChange = { username = it },
                                label = { Text(text = "Enter Mobile Number") },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),

                                trailingIcon = {
                                    if (username.isNotBlank())
                                        IconButton(onClick = { username = "" }) {
                                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                        }
                                }
                            )
                            Text(modifier = Modifier.padding(top = 4.dp),
                                text = "ex:5xxxxxxxxx", color = colorResource(R.color.gray))
                            Spacer(modifier = Modifier.height(8.dp))
                            TextField(
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.Transparent,
                                ),
                                value = password,
                                onValueChange = { password = it },
                                label = { Text(text = "Password") },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                trailingIcon = {
                                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                        Icon(
                                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                            contentDescription = "Password Toggle"
                                        )
                                    }
                                }
                            )
                            Text(modifier = Modifier.padding(top = 4.dp),
                                text = "At least 6 characters", color = colorResource(R.color.gray))
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {},
                                /* enabled = isFormValid, */
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(53.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(R.color.red_color),
                                    contentColor = colorResource(R.color.red_color)
                                ),

                                ) {
                                Text(text = "NEXT" ,style = TextStyle(
                                    color = colorResource(R.color.white),

                                    ))
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            TextButton(onClick = { }) {
                                Text(text = "Forgot Password?", color = Color.Gray)
                            }
                        }
                    }
                }
            }

        }
    }
}
