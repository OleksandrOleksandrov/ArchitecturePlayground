package com.oleksandr.presentation.styling.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.oleksandr.presentation.core.styling.R
import com.oleksandr.presentation.styling.theme.attribute.attributeFontSize
import com.oleksandr.presentation.styling.theme.attribute.attributeLineHeight
import com.oleksandr.presentation.styling.theme.core.ThemeTypography

val Geraldton @Composable get() = FontFamily(
    Font(R.font.geraldton_light, weight = FontWeight.Light),
    Font(R.font.geraldton_regular, weight = FontWeight.Normal),
    Font(R.font.geraldton_medium, weight = FontWeight.Medium),
    Font(R.font.geraldton_bold, weight = FontWeight.Bold),
)

val RobotoMono @Composable get() = FontFamily(
    Font(R.font.roboto_mono_light, weight = FontWeight.Light),
)

val attributeTypography @Composable get() =
    ThemeTypography(
        //region title
        titleBold01 = TextStyle(
            fontSize = 48.sp,
            lineHeight = 62.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleMedium01 = TextStyle(
            fontSize = 48.sp,
            lineHeight = 62.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleRegular01 = TextStyle(
            fontSize = 48.sp,
            lineHeight = 62.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleBold02 = TextStyle(
            fontSize = 40.sp,
            lineHeight = 54.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleMedium02 = TextStyle(
            fontSize = 40.sp,
            lineHeight = 54.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleRegular02 = TextStyle(
            fontSize = 40.sp,
            lineHeight = 54.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleBold03 = TextStyle(
            fontSize = 32.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleMedium03 = TextStyle(
            fontSize = 32.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleRegular03 = TextStyle(
            fontSize = 32.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleBold04 = TextStyle(
            fontSize = 28.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleMedium04 = TextStyle(
            fontSize = 28.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleRegular04 = TextStyle(
            fontSize = 28.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleBold05 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleMedium05 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleRegular05 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleBold06 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleMedium06 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        titleRegular06 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        //endregion title
        //region body
        bodyBold01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyMedium01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyRegular01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyBold02 = TextStyle(
            fontSize = attributeFontSize.size16,
            lineHeight = attributeLineHeight.height20,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyMedium02 = TextStyle(
            fontSize = attributeFontSize.size16,
            lineHeight = attributeLineHeight.height20,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyRegular02 = TextStyle(
            fontSize = attributeFontSize.size16,
            lineHeight = attributeLineHeight.height20,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyBold03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyMedium03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyRegular03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        bodyLight03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Light,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        //endregion body
        //region cta
        ctaBold01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaMedium01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaUnderlineMedium01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaRegular01 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaBold02 = TextStyle(
            fontSize = attributeFontSize.size16,
            lineHeight = attributeLineHeight.height20,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaMedium02 = TextStyle(
            fontSize = attributeFontSize.size16,
            lineHeight = attributeLineHeight.height20,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaUnderlineMedium02 = TextStyle(
            fontSize = attributeFontSize.size18,
            lineHeight = attributeLineHeight.height24,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaRegular02 = TextStyle(
            fontSize = attributeFontSize.size16,
            lineHeight = attributeLineHeight.height20,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaBold03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaMedium03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaUnderlineMedium03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaRegular03 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaBold04 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaMedium04 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaUnderlineMedium04 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        ctaRegular04 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        //endregion cta
        //region captions
        captionBold01 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Bold,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        captionMedium01 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        captionRegular01 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        //endregion captions
        //region strikethrought
        strikethrought01 = TextStyle(
            fontSize = attributeFontSize.size14,
            lineHeight = attributeLineHeight.height18,
            fontWeight = FontWeight.Medium,
            fontFamily = Geraldton,
            textDecoration = TextDecoration.LineThrough,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        strikethrought02 = TextStyle(
            fontSize = attributeFontSize.size12,
            lineHeight = attributeLineHeight.height16,
            fontWeight = FontWeight.Normal,
            fontFamily = Geraldton,
            textDecoration = TextDecoration.LineThrough,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        //endregion strikethrought
        //region roboto-mono
        robotoMonoLight26 = TextStyle(
            fontSize = attributeFontSize.size26,
            lineHeight = attributeLineHeight.height40,
            fontWeight = FontWeight.Light,
            fontFamily = RobotoMono,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        robotoMonoLight24 = TextStyle(
            fontSize = attributeFontSize.size24,
            lineHeight = attributeLineHeight.height32,
            fontWeight = FontWeight.Light,
            fontFamily = RobotoMono,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            ),
        ),
        //endregion roboto-mono
    )
