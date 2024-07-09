package com.example.contactlistv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactlistv2.ui.theme.ContactListV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                ContactListV2Theme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                       val contacts = listOf(
                           Contact("Cesar", "(82) 99999-9999", R.drawable.sample1),
                           Contact("Cesar2", "(82) 99999-9999", R.drawable.sample2),
                           Contact("Cesar3", "(82) 99999-9999", R.drawable.sample3),
                       )
                        ContactList(contacts = contacts)
                    }
            }
        }
    }
}

@Composable
fun ContactList(contacts: List<Contact>) {
    LazyColumn {
        items(contacts) { contact ->
            ContactItem(contact)
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Row(modifier = Modifier
        .padding(8.dp)
        .width(300.dp)
    ) {
        Column(modifier = Modifier) {
            Image(
                painter = painterResource(id = contact.image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
        }
        Column(modifier = Modifier.height(70.dp)) {
            Text(
                text = contact.name,
                modifier = Modifier
                    .width(150.dp)
                    .padding(start = 10.dp, end = 0.dp, top = 10.dp, bottom = 0.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,

            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = contact.phone,
                modifier = Modifier
                    .width(200.dp)
                    .padding(start = 10.dp, end = 0.dp, top = 0.dp, bottom = 0.dp),
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {

    ContactListV2Theme {
        val contacts = listOf(
            Contact("Cesar", "(82) 99999-9999", R.drawable.sample1),
            Contact("Cesar2", "(82) 99999-9999", R.drawable.sample2),
            Contact("Cesar3", "(82) 99999-9999", R.drawable.sample3),
        )
        ContactList(contacts = contacts)
    }
}