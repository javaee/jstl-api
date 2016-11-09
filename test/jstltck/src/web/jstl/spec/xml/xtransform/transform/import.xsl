<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:import href="xfiles/resolve.xsl"/>
  <xsl:output method="text"/>
  <xsl:template match="/">
    <xsl:for-each select="//node()|//@*">
      <xsl:variable name="node-type">
        <xsl:call-template name="node-type"/>
      </xsl:variable>
      Node is of type: <xsl:value-of select="$node-type"/>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
