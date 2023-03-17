package com.tumininu.sayso

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.tumininu.sayso.ui.base.BottomNavigationBar
import com.tumininu.sayso.ui.base.BottomNavigationGraph
import com.tumininu.sayso.ui.nowplaying.NowPlaying
import com.tumininu.sayso.ui.theme.LightOrange
import com.tumininu.sayso.ui.theme.SaysoTheme
import com.tumininu.sayso.ui.viewmodel.BaseViewModel
import com.tumininu.sayso.utils.StorageUtil
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[BaseViewModel::class.java]

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                SaysoTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background) {
                        Base(activity = this, viewModel = viewModel)
                    }
                }
            }
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> {
                try {
                    var parsedText = ""
                    val filePath =
                        data?.data?.let { StorageUtil().getFile(applicationContext, it)?.path }
                    val reader = PdfReader(filePath)
                    val n: Int = reader.numberOfPages
                    for (i in 0 until n) {
                        parsedText =
                            """
            $parsedText${PdfTextExtractor.getTextFromPage(reader, i + 1).trim { it <= ' ' }}
            
            """.trimIndent() //Extracting the content from the different pages
                    }
                    println(parsedText)
                    viewModel.openedDocument.postValue(true)
                    reader.close()
                } catch (e: Exception) {
                    println(e)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Base(modifier: Modifier = Modifier, activity: Activity, viewModel: BaseViewModel) {
    val navController = rememberNavController()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
    )
    val coroutineScope = rememberCoroutineScope()

    Scaffold(modifier = modifier
        .navigationBarsWithImePadding()
        .statusBarsPadding(), bottomBar = {
        BottomNavigationBar(navController = navController)
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            coroutineScope.launch {
                if (sheetState.isVisible) sheetState.animateTo(ModalBottomSheetValue.Hidden)
                else sheetState.animateTo(ModalBottomSheetValue.Expanded)
            }
        }, backgroundColor = LightOrange) {
            Image(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Now playing",
                colorFilter = ColorFilter.tint(Color.White))
        }
    }) {
        BottomNavigationGraph(activity = activity, navController = navController)
    }

    viewModel.openedDocument.observe(activity as LifecycleOwner) {
        if (it) {
            coroutineScope.launch {
                sheetState.animateTo(ModalBottomSheetValue.Expanded)
            }
            viewModel.openedDocument.postValue(false)
        }
    }

    if (sheetState.isVisible) {
        viewModel.openedDocument.removeObservers(activity)
    }

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.animateTo(ModalBottomSheetValue.Hidden) }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
        sheetContent = { NowPlaying(modifier = modifier) },
        modifier = modifier.fillMaxSize()
    ) {
    }
}