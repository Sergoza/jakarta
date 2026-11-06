<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Конный клуб</title>
            </head>
            <body>
                <div>
                    <a href="/api/horses">Список лошадей</a> |
                    <a href="/api/riders">Список наездников</a>
                </div>

                <xsl:if test="//item/name">
                    <h2>Лошади</h2>
                    <table border="1">
                        <tr><th>ID</th><th>Кличка</th><th>Порода</th><th>Возраст</th><th>Вес</th></tr>
                        <xsl:for-each select="//item">
                            <tr>
                                <td><xsl:value-of select="id"/></td>
                                <td><xsl:value-of select="name"/></td>
                                <td><xsl:value-of select="breed"/></td>
                                <td><xsl:value-of select="age"/></td>
                                <td><xsl:value-of select="weight"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </xsl:if>

                <xsl:if test="//item/fio">
                    <h2>Наездники</h2>
                    <table border="1">
                        <tr><th>ID</th><th>ФИО</th><th>Опыт</th><th>Телефон</th></tr>
                        <xsl:for-each select="//item">
                            <tr>
                                <td><xsl:value-of select="id"/></td>
                                <td><xsl:value-of select="fio"/></td>
                                <td><xsl:value-of select="experience"/></td>
                                <td><xsl:value-of select="phoneNumber"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </xsl:if>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>