package org.intellij.markdown.parser.markerblocks

import org.intellij.markdown.parser.LookaheadText
import org.intellij.markdown.parser.MarkerProcessor
import org.intellij.markdown.parser.ProductionHolder
import org.intellij.markdown.parser.constraints.MarkdownConstraints

public interface MarkerBlockProvider<T : MarkerProcessor.StateInfo> {
    fun createMarkerBlocks(pos: LookaheadText.Position,
                           productionHolder: ProductionHolder,
                           stateInfo: T): List<MarkerBlock>

    fun interruptsParagraph(pos: LookaheadText.Position, constraints: MarkdownConstraints): Boolean

    companion object {
        public fun isStartOfLineWithConstraints(pos: LookaheadText.Position, constraints: MarkdownConstraints): Boolean {
            return pos.offsetInCurrentLine == constraints.getCharsEaten(pos.currentLine)
        }
    }
}