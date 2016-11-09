<?xml version="1.0"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html"/>

  <xsl:template match="text()">
    <h4><xsl:value-of select="."/></h4>
  </xsl:template>

</xsl:stylesheet>
