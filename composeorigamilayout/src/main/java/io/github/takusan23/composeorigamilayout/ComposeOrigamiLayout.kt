package io.github.takusan23.composeorigamilayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints

/**
 * 折り返すLayout
 *
 * @param modifier Paddingなど
 * @param isAcceptSort 並び替えしてもいいならtrue
 * @param content 表示したい部品
 * */
@Composable
fun OrigamiLayout(
    modifier: Modifier = Modifier,
    isAcceptSort: Boolean = false,
    content: @Composable () -> Unit,
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        // この中に入るCompose（子供Compose）の幅とかの情報の配列にする
        // なんかConstraints()のmaxのところはMAX_VALUE入れといてminには0を入れてあげれば大きさが取れるようになる
        val placeableList = measurables.map { it.measure(Constraints(0, constraints.maxWidth, 0, constraints.maxHeight)) }.toMutableList()
        // 最終的に入れるときに使うやつ
        val childrenDataList = arrayListOf<Triple<Int, Int, Placeable>>()
        // このComposeの幅
        val origamiWidth = constraints.maxWidth
        // 高さ計算
        var origamiHeight = 0
        // 列に入ってるComposeの合計の幅
        var lineWidth = 0
        // 並び替えを許可している場合は並び替える
        if (isAcceptSort) {
            placeableList.sortBy { placeable -> placeable.width }
        }
        // 子供Composeがの位置を決定する
        placeableList.forEach { placeable ->
            if (lineWidth + placeable.width < origamiWidth) {
                // 今の行の幅が足りている場合
                // width / height / placeable
                childrenDataList.add(Triple(lineWidth, origamiHeight, placeable))
                lineWidth += placeable.width
            } else {
                // 足りてない
                // 次はもう入らないので次の行へ
                lineWidth = 0
                origamiHeight += placeable.height
                // width / height / placeable
                childrenDataList.add(Triple(lineWidth, origamiHeight, placeable))
                // 次の行に移動して幅を足す
                lineWidth = placeable.width
            }
        }
        // 子Composeを置いていく
        // origamiHeightは、部品を置く際の座標（左上）になりますので、高さとして使うにはもう一度部品の高さを足してあげないといけない
        val lastItemHeight = if (placeableList.isEmpty()) 0 else placeableList.last().height
        layout(width = constraints.maxWidth, height = origamiHeight + lastItemHeight) {
            childrenDataList.forEach { triple ->
                val xPos = triple.first
                val yPos = triple.second
                val placeable = triple.third
                // 設置
                placeable.placeRelative(xPos, yPos)
            }
        }
    }
}