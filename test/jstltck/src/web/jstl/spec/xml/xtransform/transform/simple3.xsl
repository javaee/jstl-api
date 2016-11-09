<?xml version="1.0"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html"/>
  <xsl:template match="text()">
    <a><xsl:value-of select="."/></a>
  </xsl:template>

</xsl:stylesheet>
