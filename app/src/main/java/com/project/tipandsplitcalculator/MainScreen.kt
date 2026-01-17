package com.project.tipandsplitcalculator

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var amount by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("") }
    var split by remember { mutableStateOf(0) }
    Surface() {
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                shape = RoundedCornerShape(12.dp), color = Color.Gray
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    if (!amount.equals("") && !tipPercent.equals("") && split != 0) {
                        val ans =
                            (amount.toInt() + (amount.toInt() * tipPercent.toInt()) / 100) / split
                        Text("₹" + ans.toString(), fontSize = 50.sp)
                    }
                    if (!amount.equals("") && !tipPercent.equals("") && split == 0) {
                        val ans =
                            (amount.toInt() + (amount.toInt() * tipPercent.toInt()) / 100)
                        Text("₹" + ans.toString(), fontSize = 50.sp)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.DarkGray),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Enter Amount",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(12.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                TextField(
                    value = amount,
                    onValueChange = { a -> amount = a },
                    modifier = Modifier.padding(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Enter Here") }
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Enter Tip Percent",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(12.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                TextField(
                    value = tipPercent,
                    onValueChange = { a -> tipPercent = a },
                    modifier = Modifier.padding(12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Enter Here") }
                )
                Spacer(modifier = Modifier.size(10.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Split in",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        CustomButton(Icons.Default.KeyboardArrowUp) {
                            split++
                        }
                        Text(text = split.toString(), fontSize = 20.sp, color = Color.White)
                        CustomButton(Icons.Default.KeyboardArrowDown) {
                            split--
                        }
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }

        }
    }
}

@Composable
fun CustomButton(icon: ImageVector, onClick: () -> Unit = {}) {
    androidx.compose.material3.Icon(icon, contentDescription = "", modifier = Modifier.clickable {
        onClick()
    })

}

@Preview(showBackground = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    MainScreen()
}