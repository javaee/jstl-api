<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:param name="message">DEFAULT</xsl:param>
    <xsl:param name="fsize">8pt</xsl:param>
    <xsl:template match="text()">
       <font size="{$fsize}"><xsl:value-of select="$message"/></font>
    </xsl:template>
</xsl:stylesheet>
