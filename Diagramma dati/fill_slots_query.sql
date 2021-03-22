USE [sportshub-jpa]
GO

INSERT INTO [dbo].[Slot]
           ([dataOraFine]
           ,[dataOraInizio]
           ,[prezzo]
           ,[scontoPercent]
           ,[scontoRiscattato]
           ,[campo_idCampo]
           ,[gruppo_idGruppo]
           ,[referente_email])
     VALUES
           (<dataOraFine, datetime2(7),>
           ,<dataOraInizio, datetime2(7),>
           ,<prezzo, numeric(8,2),>
           ,<scontoPercent, int,>
           ,<scontoRiscattato, bit,>
           ,<campo_idCampo, int,>
           ,<gruppo_idGruppo, int,>
           ,<referente_email, varchar(100),>)
GO