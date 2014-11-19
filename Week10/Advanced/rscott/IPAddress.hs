module IPAddress where

import Data.Bits
import Data.Word (Word8, Word32)

type IPString = String

int32ToIP :: Word32 -> IPString
int32ToIP int32 = shows (octet 1 int32)
                . showChar '.'
                . shows (octet 2 int32)
                . showChar '.'
                . shows (octet 3 int32)
                . showChar '.'
                . shows (octet 4 int32)
                $ ""

octet :: Word8 -> Word32 -> Word8
octet n i = fromIntegral $
            i `shiftR` (32-8*(fromIntegral n)) .&. 255