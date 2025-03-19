package com.example.vigiform.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

// Vector 1

public val Dog: ImageVector
    get() {
        if (_Dog != null) {
            return _Dog!!
        }
        _Dog = ImageVector.Builder(
            name = "Dog",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(11.25f, 16.25f)
                horizontalLineToRelative(1.5f)
                lineTo(12f, 17f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16f, 14f)
                verticalLineToRelative(0.5f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(4.42f, 11.247f)
                arcTo(13.152f, 13.152f, 0f, isMoreThanHalf = false, isPositiveArc = false, 4f, 14.556f)
                curveTo(4f, 18.728f, 7.582f, 21f, 12f, 21f)
                reflectiveCurveToRelative(8f, -2.272f, 8f, -6.444f)
                arcToRelative(11.702f, 11.702f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.493f, -3.309f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8f, 14f)
                verticalLineToRelative(0.5f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8.5f, 8.5f)
                curveToRelative(-0.384f, 1.05f, -1.083f, 2.028f, -2.344f, 2.5f)
                curveToRelative(-1.931f, 0.722f, -3.576f, -0.297f, -3.656f, -1f)
                curveToRelative(-0.113f, -0.994f, 1.177f, -6.53f, 4f, -7f)
                curveToRelative(1.923f, -0.321f, 3.651f, 0.845f, 3.651f, 2.235f)
                arcTo(7.497f, 7.497f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 5.277f)
                curveToRelative(0f, -1.39f, 1.844f, -2.598f, 3.767f, -2.277f)
                curveToRelative(2.823f, 0.47f, 4.113f, 6.006f, 4f, 7f)
                curveToRelative(-0.08f, 0.703f, -1.725f, 1.722f, -3.656f, 1f)
                curveToRelative(-1.261f, -0.472f, -1.855f, -1.45f, -2.239f, -2.5f)
            }
        }.build()
        return _Dog!!
    }

private var _Dog: ImageVector? = null


// Vector 2

public val Electric_bolt: ImageVector
    get() {
        if (_Electric_bolt != null) {
            return _Electric_bolt!!
        }
        _Electric_bolt = ImageVector.Builder(
            name = "Electric_bolt",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(280f, 880f)
                lineToRelative(160f, -300f)
                lineToRelative(-320f, -40f)
                lineToRelative(480f, -460f)
                horizontalLineToRelative(80f)
                lineTo(520f, 380f)
                lineToRelative(320f, 40f)
                lineTo(360f, 880f)
                close()
                moveToRelative(222f, -247f)
                lineToRelative(161f, -154f)
                lineToRelative(-269f, -34f)
                lineToRelative(63f, -117f)
                lineToRelative(-160f, 154f)
                lineToRelative(268f, 33f)
                close()
                moveToRelative(-22f, -153f)
            }
        }.build()
        return _Electric_bolt!!
    }

private var _Electric_bolt: ImageVector? = null

// Vector 3

public val TestTubeDiagonal: ImageVector
    get() {
        if (_TestTubeDiagonal != null) {
            return _TestTubeDiagonal!!
        }
        _TestTubeDiagonal = ImageVector.Builder(
            name = "TestTubeDiagonal",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(21f, 7f)
                lineTo(6.82f, 21.18f)
                arcToRelative(2.83f, 2.83f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.99f, -0.01f)
                arcToRelative(2.83f, 2.83f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -4f)
                lineTo(17f, 3f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16f, 2f)
                lineToRelative(6f, 6f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12f, 16f)
                horizontalLineTo(4f)
            }
        }.build()
        return _TestTubeDiagonal!!
    }

private var _TestTubeDiagonal: ImageVector? = null

// Vector 4

public val FlaskConical: ImageVector
    get() {
        if (_FlaskConical != null) {
            return _FlaskConical!!
        }
        _FlaskConical = ImageVector.Builder(
            name = "FlaskConical",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10f, 2f)
                verticalLineToRelative(7.527f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.211f, 0.896f)
                lineTo(4.72f, 20.55f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.9f, 1.45f)
                horizontalLineToRelative(12.76f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.9f, -1.45f)
                lineToRelative(-5.069f, -10.127f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 9.527f)
                verticalLineTo(2f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8.5f, 2f)
                horizontalLineToRelative(7f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(7f, 16f)
                horizontalLineToRelative(10f)
            }
        }.build()
        return _FlaskConical!!
    }

private var _FlaskConical: ImageVector? = null

