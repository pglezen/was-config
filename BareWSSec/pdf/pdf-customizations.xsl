<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fo="http://www.w3.org/1999/XSL/Format" 
  xmlns:d="http://docbook.org/ns/docbook">

  <xsl:import href="../softlinks/docbook/fo/docbook.xsl" />

  <xsl:param name="shade.verbatim" select="1" />
  <xsl:attribute-set name="monospace.verbatim.properties">
    <xsl:attribute name="font-size">9pt</xsl:attribute>
    <xsl:attribute name="wrap-option">wrap</xsl:attribute>
  </xsl:attribute-set>


</xsl:stylesheet>