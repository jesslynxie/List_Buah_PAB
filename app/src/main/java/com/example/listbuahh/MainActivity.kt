package com.example.listbuahh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.listbuahh.ui.theme.ListBuahhTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListBuahhTheme {
                FruitApp()
            }
        }
    }
}

data class Fruit(
    val name: String,
    val imageUrl: String,
    val origin: String,
    val taste: String,
    val description: String,
    val benefits: List<String>
)

val fruitList = listOf(
    Fruit(
        "Melon", "https://img.icons8.com/color/160/melon.png", "Asia & Afrika", "Manis harum legit",
        "Melon adalah buah dari keluarga Cucurbitaceae yang memiliki daging berwarna hijau atau oranye dengan aroma yang harum dan rasa yang manis legit.",
        listOf("Menjaga keseimbangan elektrolit", "Menyehatkan mata", "Mencegah dehidrasi", "Kaya vitamin A dan C")
    ),
    Fruit(
        "Pepaya", "https://img.icons8.com/color/160/papaya.png", "Meksiko & Amerika Tengah", "Manis lembut",
        "Pepaya adalah buah tropis dari pohon Carica papaya yang berasal dari Meksiko. Memiliki daging berwarna oranye cerah dan biji hitam di bagian tengahnya.",
        listOf("Memperlancar pencernaan (papain)", "Menjaga kesehatan jantung", "Memperkuat imunitas", "Baik untuk kesehatan mata")
    ),
    Fruit(
        "Durian", "https://img.icons8.com/color/160/durian.png", "Asia Tenggara", "Manis creamy gurih",
        "Durian dijuluki Raja Buah di Asia Tenggara. Buah berkulit keras berduri ini memiliki daging berwarna kuning krem dengan aroma yang sangat kuat dan khas.",
        listOf("Sumber energi tinggi", "Kaya tryptophan untuk mood", "Mengandung mineral penting", "Kaya serat dan vitamin B")
    ),
    Fruit(
        "Rambutan", "https://img.icons8.com/color/160/rambutan.png", "Malaysia & Indonesia", "Manis-asam segar",
        "Rambutan adalah buah tropis dari pohon Nephelium lappaceum. Nama rambutan berasal dari kata rambut karena kulitnya yang penuh dengan bulu-bulu halus berwarna merah.",
        listOf("Mendukung kesehatan tulang", "Kaya zat besi mencegah anemia", "Mengandung vitamin C", "Baik untuk kesehatan rambut")
    ),
    Fruit(
        "Leci", "https://img.icons8.com/color/160/lychee.png", "Tiongkok Selatan", "Manis harum segar",
        "Leci adalah buah kecil tropis dari pohon Litchi chinensis yang berasal dari China. Memiliki kulit bertekstur merah-pink dan daging putih transparan yang manis.",
        listOf("Kaya vitamin C", "Meningkatkan sirkulasi darah", "Membantu penurunan berat badan", "Mengandung antioksidan kuat")
    ),
    Fruit(
        "Salak", "https://img.icons8.com/color/160/salak.png", "Indonesia", "Manis-asam sepat",
        "Salak adalah buah asli Indonesia dari pohon Salacca zalacca. Buah berbentuk seperti telur dengan kulit bersisik coklat seperti ular ini terkenal dengan rasa khasnya.",
        listOf("Mengontrol kadar gula darah", "Menjaga kesehatan mata", "Kaya tanin untuk diare", "Meningkatkan stamina")
    ),
    Fruit(
        "Jambu Biji", "https://img.icons8.com/color/160/guava.png", "Amerika Tengah & Selatan", "Manis-asam segar",
        "Jambu biji adalah buah tropis dari pohon Psidium guajava. Memiliki kulit hijau kekuningan dengan daging merah atau putih yang kaya akan vitamin C.",
        listOf("Vitamin C tertinggi (4x jeruk)", "Membantu penyembuhan demam berdarah", "Melancarkan pencernaan", "Mengontrol tekanan darah")
    ),
    Fruit(
        "Kiwi", "https://img.icons8.com/color/160/kiwi.png", "Tiongkok / Selandia Baru", "Manis-asam segar",
        "Kiwi adalah buah dari tanaman Actinidia deliciosa yang berasal dari Tiongkok. Terkenal dengan pola biji hitam radialnya dan daging hijau segar.",
        listOf("Kaya vitamin C dan K", "Memperbaiki kualitas tidur", "Menjaga kesehatan jantung", "Mendukung fungsi imun")
    ),
    Fruit(
        "Buah Naga", "https://img.icons8.com/color/160/pitaya.png", "Amerika Tengah & Selatan", "Manis lembut ringan",
        "Buah naga atau pitaya adalah buah dari kaktus genus Hylocereus. Buah eksotis berwarna merah cerah dengan sisik hijau ini memiliki daging putih berbintik hitam.",
        listOf("Kaya antioxidant betacyanin", "Mendukung kesehatan usus", "Menstabilkan gula darah", "Memperkuat imun")
    ),
    Fruit(
        "Apel", "https://img.icons8.com/color/160/apple.png", "Asia Tengah", "Manis-asam segar",
        "Apel adalah buah pomaceous dari pohon Malus domestica. Buah ini merupakan salah satu buah paling populer di dunia dengan ratusan varietas berbeda.",
        listOf("Menjaga kesehatan jantung", "Menurunkan risiko diabetes", "Membantu pencernaan", "Kaya antioksidan")
    ),
    Fruit(
        "Markisa", "https://img.icons8.com/color/160/passion-fruit.png", "Amerika Selatan (Brasil)", "Asam-manis eksotis",
        "Markisa atau passion fruit adalah buah dari tanaman merambat Passiflora edulis. Buah bulat berwarna ungu atau kuning ini berisi biji hitam berlendir oranye.",
        listOf("Membantu mengatasi kecemasan", "Kaya serat untuk pencernaan", "Menurunkan tekanan darah", "Mengandung riboflavin dan niasin")
    ),
    Fruit(
        "Sirsak", "https://img.icons8.com/color/160/soursop.png", "Amerika Tengah & Karibia", "Asam-manis segar",
        "Sirsak adalah buah dari pohon Annona muricata yang berasal dari Amerika Tengah. Buah berwarna hijau dengan duri lunak ini memiliki daging putih berserat asam-manis.",
        listOf("Mengandung acetogenin anti-kanker", "Memperkuat sistem imun", "Mengatasi insomnia", "Kaya vitamin C dan B")
    ),
    Fruit(
        "Alpukat", "https://img.icons8.com/color/160/avocado.png", "Meksiko & Amerika Tengah", "Gurih creamy lembut",
        "Alpukat adalah buah berry besar dari pohon Persea americana. Buah ini unik karena kaya akan lemak sehat tak jenuh tunggal dan memiliki daging berwarna hijau muda.",
        listOf("Kaya lemak sehat omega-9", "Menurunkan kolesterol jahat", "Kaya folat untuk ibu hamil", "Menjaga kesehatan mata")
    ),
    Fruit(
        "Semangka", "https://img.icons8.com/color/160/watermelon.png", "Afrika Selatan", "Manis segar",
        "Semangka adalah buah besar dari keluarga Cucurbitaceae dengan kulit hijau and daging merah yang mengandung 92% air. Sangat menyegarkan di musim panas.",
        listOf("Menghidrasi tubuh", "Menurunkan tekanan darah", "Mencegah kerusakan otot", "Kaya likopen anti-kanker")
    ),
    Fruit(
        "Stroberi", "https://img.icons8.com/color/160/strawberry.png", "Amerika & Eropa", "Manis-asam segar",
        "Stroberi adalah buah merah berbentuk hati dari genus Fragaria. Dikenal dengan rasa manis-asamnya yang khas dan aroma yang menggugah selera.",
        listOf("Kaya vitamin C dan mangan", "Menjaga kesehatan jantung", "Mengontrol gula darah", "Baik untuk kecantikan kulit")
    ),
    Fruit(
        "Nanas", "https://img.icons8.com/color/160/pineapple.png", "Amerika Selatan", "Manis-asam segar",
        "Nanas adalah buah tropis berduri dari tanaman Ananas comosus. Memiliki mahkota daun hijau yang khas dan daging berwarna kuning keemasan yang juicy.",
        listOf("Membantu pencernaan (bromelain)", "Memperkuat tulang", "Mengurangi peradangan", "Meningkatkan imunitas")
    ),
    Fruit(
        "Mangga", "https://img.icons8.com/color/160/mango.png", "India", "Manis harum",
        "Mangga adalah raja buah tropis yang berasal dari anak benua India. Buah berdaging kuning-oranye ini memiliki rasa manis yang khas dan aroma yang harum.",
        listOf("Memperkuat sistem imun", "Menjaga kesehatan mata", "Melancarkan pencernaan", "Kaya vitamin A and C")
    ),
    Fruit(
        "Anggur", "https://img.icons8.com/color/160/grapes.png", "Eropa & Asia Barat", "Manis-asam",
        "Anggur adalah buah berry kecil yang tumbuh dalam kelompok di tanaman merambat Vitis vinifera. Ada yang berwarna hijau, merah, hingga ungu kehitaman.",
        listOf("Mengandung resveratrol anti-kanker", "Menjaga kesehatan jantung", "Mencegah penuaan dini", "Kaya antioksidan")
    ),
    Fruit(
        "Pisang", "https://img.icons8.com/color/160/banana.png", "Asia Tenggara", "Manis lembut",
        "Pisang adalah buah tropis dari tanaman Musa. Buah berwarna kuning ini sangat populer di seluruh dunia dan kaya akan kalium serta karbohidrat.",
        listOf("Sumber energi instan", "Menjaga kesehatan jantung", "Mencegah kram otot", "Meningkatkan mood")
    ),
    Fruit(
        "Jeruk", "https://img.icons8.com/color/160/orange.png", "Asia Selatan", "Manis-asam segar",
        "Jeruk adalah buah citrus yang kaya vitamin C. Buah bulat berwarna oranye ini termasuk dalam keluarga Rutaceae dan banyak dikonsumsi segar maupun dibuat jus.",
        listOf("Meningkatkan imunitas tubuh", "Mencegah anemia", "Menjaga kesehatan kulit", "Sumber vitamin C terbaik")
    )
)

@Composable
fun FruitApp() {
    var selectedFruit by remember { mutableStateOf<Fruit?>(null) }

    if (selectedFruit == null) {
        FruitListScreen(onFruitClick = { selectedFruit = it })
    } else {
        FruitDetailScreen(fruit = selectedFruit!!, onBack = { selectedFruit = null })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitListScreen(onFruitClick: (Fruit) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Daftar Buah-buahan",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF212121)
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(fruitList) { fruit ->
                FruitItem(fruit = fruit, onClick = { onFruitClick(fruit) })
            }
        }
    }
}

@Composable
fun FruitItem(fruit: Fruit, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = fruit.imageUrl,
                contentDescription = fruit.name,
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = fruit.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 0.5.dp,
            color = Color.LightGray
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitDetailScreen(fruit: Fruit, onBack: () -> Unit) {
    BackHandler { onBack() }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Detail: ${fruit.name}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text(
                            text = "←",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF212121)
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2E7D32))
                    .padding(vertical = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(
                        modifier = Modifier.size(160.dp),
                        shape = RoundedCornerShape(0.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            AsyncImage(
                                model = fruit.imageUrl,
                                contentDescription = fruit.name,
                                modifier = Modifier.size(120.dp),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = fruit.name,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(vertical = 16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🌍", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Asal", fontSize = 12.sp, color = Color.Gray)
                    }
                    Text(
                        text = fruit.origin,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                VerticalDivider(modifier = Modifier.fillMaxHeight().width(0.5.dp), color = Color.LightGray)
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("😋", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Rasa", fontSize = 12.sp, color = Color.Gray)
                    }
                    Text(
                        text = fruit.taste,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
            HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)

            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📖", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Deskripsi",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32),
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    shape = RoundedCornerShape(4.dp),
                    border = androidx.compose.foundation.BorderStroke(0.5.dp, Color.LightGray)
                ) {
                    Text(
                        text = fruit.description,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = Color.DarkGray
                    )
                }
            }

            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("✅", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Manfaat Kesehatan",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32),
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    shape = RoundedCornerShape(4.dp),
                    border = androidx.compose.foundation.BorderStroke(0.5.dp, Color.LightGray)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        fruit.benefits.forEach { benefit ->
                            Text(
                                text = "• $benefit",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FruitAppPreview() {
    ListBuahhTheme {
        FruitApp()
    }
}
