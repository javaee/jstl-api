<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template name="node-type">
    <xsl:param name="node" select="."/>
    <xsl:apply-templates mode="nodetype" select="$node"/>
  </xsl:template>
  <xsl:template mode="nodetype" match="*">element</xsl:template>
  <xsl:template mode="nodetype" match="@*">attribute</xsl:template>
  <xsl:template mode="nodetype" match="text()">text</xsl:template>
</xsl:stylesheet>
