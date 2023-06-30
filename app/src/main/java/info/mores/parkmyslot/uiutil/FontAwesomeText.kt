package info.mores.parkmyslot.uiutil

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.mores.parkmyslot.R

@Composable
fun FontAwesomeText(
    modifier: Modifier,
    fontID: Int,
    fontSize: TextUnit,
    textColor: Color
) {
    Text(
        text = stringResource(
            id = fontID
        ),
        modifier = modifier,
        fontFamily = getFontType(),
        fontSize = fontSize,
        color = textColor,
        textAlign = TextAlign.Center
    )

}




fun getFontType(): FontFamily {
    return FontFamily(Font(R.font.fa_light_300))
}





@Preview(showBackground = true)
@Composable
fun FontAwesomeTextPre() {
    FontAwesomeText(
        modifier = Modifier.padding(10.dp),
        R.string.far_fa_book,
        fontSize = 50.sp,
        Color.Red)
}